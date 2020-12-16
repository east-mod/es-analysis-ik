package org.analyzer.lucene;

import org.analyzer.config.Configuration;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

/**
 * AUTHOR: zorigt
 * DATE  : 2020/12/15
 * WEEK  : Tue
 * TIME  : 10:08
 */
public class IKTokenizer extends Tokenizer {

    public IKTokenizer(Configuration configuration) {
    }

    @Override
    public boolean incrementToken() throws IOException {
        return false;
    }

    @Override
    public void reset() throws IOException {
        super.reset();
    }

    @Override
    public void end() throws IOException {
        super.end();
    }


    public static void tryAnalyzer(String s, Analyzer analyzer) {
        try {
            TokenStream tokenStream = analyzer.tokenStream("", new StringReader(s));
            CharTermAttribute cta = tokenStream.addAttribute(CharTermAttribute.class);
            tokenStream.reset();
            System.out.print(analyzer.getClass().getSimpleName() + ":");
            while (tokenStream.incrementToken()) {
                System.out.print("[" + cta + "]");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Analyzer aly1 = new StandardAnalyzer();
        Analyzer aly2 = new StopAnalyzer(new CharArraySet(new LinkedList<>(), false));
        Analyzer aly3 = new SimpleAnalyzer();
        Analyzer aly4 = new WhitespaceAnalyzer();
        Analyzer aly5 = new CJKAnalyzer();

        String str = "满足上面两点要求就可以实现热更新分词了，不需要重启 ES 实例。";

        tryAnalyzer(str, aly1);
        tryAnalyzer(str, aly2);
        tryAnalyzer(str, aly3);
        tryAnalyzer(str, aly4);
        tryAnalyzer(str, aly5);
    }
}
