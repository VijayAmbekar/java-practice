package designs.stack.pagevisits;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter
@Setter
@Builder
@Slf4j
public class Page {
    private String pageURL;
    private List<String> links;
}
