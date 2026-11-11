package designs.stack.pagevisits;

import designs.stack.LinkedListStack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Slf4j
public class PageVisitor {
    LinkedListStack<String> pagesToVisit = new LinkedListStack<>();
    private int visitedCount = 0;
    private Set<Page> visitedPages = new LinkedHashSet<>();


    public void visitPages(String url, Map<String, Page> pages) {
        // Fetch Page
        // Capture the visit
        // put links into Stack in reverese
        // repeat

        if(pages.containsKey(url)) {
            Page processPage = pages.get(url);

            log.info("Visited Page: {}", processPage.getPageURL());
            visitedCount++;
            visitedPages.add(processPage);

            List<String> links = processPage.getLinks();
            if(!CollectionUtils.isEmpty(links)) {
                for(int i=links.size()-1; i>=0; i--) {
                    pagesToVisit.push(links.get(i));
                }
            }
            visitLinks(pages);
        }
    }

    public void visitLinks(Map<String, Page> pages) {
        while(!pagesToVisit.isEmpty()) {
            String pageLink = pagesToVisit.pop();
            Page processPage = pages.get(pageLink);

            log.info("Visited Page: {}", processPage.getPageURL());
            visitedCount++;
            visitedPages.add(processPage);

            List<String> links = processPage.getLinks();
            if(!CollectionUtils.isEmpty(links)) {
                for(int i=links.size()-1; i>=0; i--) {
                    pagesToVisit.push(links.get(i));
                }
            }
        }
    }

    public void displayStatsForReconciliation() {
        log.info("Visited Page Count: {}", visitedCount);
        log.info("Visited Page Links: ");
        visitedPages.stream().map(p -> p.getPageURL()).forEach(System.out::println);
    }
}
