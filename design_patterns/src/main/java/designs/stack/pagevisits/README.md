# Page Hierarchy DFS Traversal — Requirements & Design

Traversal engine for a hierarchical web-page graph: visit every page **exactly once**
in **depth-first order**, at arbitrary nesting depth, with a **reconciliation proof**
that the number of visits equals the number of unique reachable pages.

---

## 1. Overview

The system crawls/traverses a hierarchy of web pages starting from a single root.
Each page contains an ordered list of outbound links (child pages). Pages may be
reachable from multiple parents (the structure is a **DAG**, not strictly a tree),
and cycles may exist.

The traversal must:

- Follow **depth-first order**
- Visit each unique page (identified by URL) **exactly once**
- Scale to **deeply nested** structures without `StackOverflowError`
- Produce a **reconciliation report** proving `visits == unique reachable pages`

---

## 2. Domain Model

```
Page
 ├── url        : String          // unique identifier
 └── links      : List<Page>      // ordered outbound links
```

- A page is **visited** when its URL is first added to the visited set.
- Links may point to already-visited pages, to the same page multiple times, or
  back to an ancestor (cycle). All such links are skipped.
- The graph is finite and reachable from a single root.

---

## 3. Functional Requirements

### Scope / Model

**FR-1 — Page hierarchy model**
The system shall model pages as a directed graph where each page has a unique URL
and an ordered list of links. Shared children and cycles shall be supported.

*Acceptance:* Exposes `page.url` and `page.links`; handles DAG and cyclic input.

**FR-2 — Root entry point**
Traversal shall start from a single designated root page.

---

### Traversal Order

**FR-3 — Depth-first traversal**
Traversal shall follow **DFS pre-order**: a node's descendants are fully explored
before its next sibling.

*Acceptance:* Emitted visit sequence matches expected DFS pre-order on a fixture graph.

**FR-4 — Deterministic order**
Given identical input and identical child ordering, the visit sequence shall be
identical across runs.

*Acceptance:* Two runs produce byte-identical visit logs.

**FR-5 — No recursion dependence**
Traversal shall not rely on the JVM call stack for depth.

*Acceptance:* Depth ≥ 100,000 chain completes without `StackOverflowError`.

---

### Visit-Exactly-Once

**FR-6 — Single visit per page**
Each unique URL shall be visited exactly once, regardless of how many parents link
to it or how many duplicate links exist.

*Acceptance:* A page with N inbound links appears exactly once in the visit log.

**FR-7 — Duplicate / revisited link handling**
Duplicate links and links to already-visited pages shall be skipped without
incrementing the visit counter.

*Acceptance:* Repeated links to the same child yield one visit; skipped links
are not counted.

---

### Scalability

**FR-8 — Deep nesting support**
Memory usage shall be proportional to the number of unique pages plus the depth
of the active DFS path — not to total graph depth on the JVM call stack.

*Acceptance:* Verified at depth ≥ 100,000 with bounded heap growth.

**FR-9 — Bounded auxiliary structures**
Visited tracking shall use a hash-based set (`HashSet`); the DFS worklist shall
use an array-backed deque (`ArrayDeque`). Neither `java.util.Stack` nor
`LinkedList` shall be used, and child lists shall not be sorted or reversed
to achieve DFS order.

*Acceptance:* Code review confirms `HashSet` + `ArrayDeque`; no `.sort()` / `.reverse()`
on `page.links`.

---

### Reconciliation

**FR-10 — Visit counter**
The system shall maintain an integer count incremented **only** when a page is
first marked visited.

*Acceptance:* Counter increments exactly once per unique URL.

**FR-11 — Reconciliation invariant**
At end of traversal, the system shall assert all of:

| Invariant | Meaning |
|---|---|
| `visitCount == visitedSet.size()` | Counted visits ↔ recorded unique pages |
| `duplicateVisits == 0` | No URL visited twice |
| `reachablePagesNotVisited == 0` | No reachable page missed |
| `visitCount == uniqueReachablePages` | Matches true unique-page total |

> **Note on "visits = links":** interpreted as **unique visits = unique reachable
> pages**. In a DAG, raw link-edge count exceeds page count. See §6.

*Acceptance:* All invariants pass and are logged.
