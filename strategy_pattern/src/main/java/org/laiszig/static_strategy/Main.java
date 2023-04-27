package org.laiszig.static_strategy;

import org.w3c.dom.Text;

import java.util.List;
import java.util.function.Supplier;

enum OutputFormat {
    MARKDOWN, HTML
}

// html <ul><li></li></ul>
// markdown *foo *bar

interface ListStrategy {
    default void start(StringBuilder sb) {}
    void addListItem(StringBuilder sb, String item);
    default void end (StringBuilder sb) {}
}

class MarkdownListStrategy implements ListStrategy {

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append(" * ").append(item).append(System.lineSeparator());
    }
}

class HtmlListStrategy implements ListStrategy {

    @Override
    public void start(StringBuilder sb) {
        sb.append("<ul>").append(System.lineSeparator());
    }

    @Override
    public void addListItem(StringBuilder sb, String item) {
        sb.append("     <li>")
                .append(item)
                .append("</li>")
                .append(System.lineSeparator());
    }

    @Override
    public void end(StringBuilder sb) {
        sb.append("</ul>").append(System.lineSeparator());
    }
}

class TextProcessor<LS extends ListStrategy> {

    private StringBuilder sb = new StringBuilder();
    private LS listStrategy;

    public TextProcessor(Supplier<? extends LS> ctor){
        listStrategy = ctor.get();
    }

    public void appendList(List<String> items) {
        listStrategy.start(sb);
        for (String item : items)
            listStrategy.addListItem(sb, item);
        listStrategy.end(sb);
    }

    public void clear() {
        sb.setLength(0);
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        TextProcessor<MarkdownListStrategy> textProcessor
                = new TextProcessor<>(MarkdownListStrategy::new);
        textProcessor.appendList(List.of("alpha", "beta", "gama"));
        System.out.println(textProcessor);

        TextProcessor<HtmlListStrategy> textProcessor2
                = new TextProcessor<>(HtmlListStrategy::new);
        textProcessor2.appendList(List.of("alpha", "beta", "gama"));
        System.out.println(textProcessor2);
    }
}