package oo.tinyweb;

import java.util.List;
import java.util.Map;

public interface JavaView {
    String render(Map<String, List<String>> model);
}
