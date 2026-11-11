package designs.stack.pagevisits;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageVisitClient {

    public static void main(String[] args) {
        Map<String,Page> pages = createPageHierarchy();

        PageVisitor pageVisitor = new PageVisitor();
        pageVisitor.visitPages("1", pages);
        pageVisitor.displayStatsForReconciliation();
    }

    public static Map<String,Page> createPageHierarchy() {
        // Root
        Map<String, Page> pages= new HashMap<>();
        Page root = Page.builder().pageURL("1")
                .links(List.of("1.1", "1.2", "1.3")).build();

        Page pg1 = Page.builder().pageURL("1.1")
                .links(List.of("1.1.1", "1.1.2")).build();
        Page pg2 = Page.builder().pageURL("1.1.1").build();

        Page pg3 = Page.builder().pageURL("1.1.2").build();

        Page pg4 = Page.builder().pageURL("1.2")
                .links(List.of("1.2.1", "1.2.2")).build();

        Page pg5 = Page.builder().pageURL("1.2.1").build();
        Page pg6 = Page.builder().pageURL("1.2.2").build();

        Page pg7 = Page.builder().pageURL("1.3").build();



        pages.put(root.getPageURL(), root);
        pages.put(pg1.getPageURL(), pg1);
        pages.put(pg2.getPageURL(), pg2);
        pages.put(pg3.getPageURL(), pg3);
        pages.put(pg4.getPageURL(), pg4);
        pages.put(pg5.getPageURL(), pg5);
        pages.put(pg6.getPageURL(), pg6);
        pages.put(pg7.getPageURL(), pg7);

        return pages;
    }
}
