package org.analyzer.lucene;

import org.analyzer.config.Configuration;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Tokenizer;

/**
 * AUTHOR: zorigt
 * DATE  : 2020/12/15
 * WEEK  : Tue
 * TIME  : 10:08
 */
public class IKAnalyzer extends Analyzer {
    private final Configuration configuration;

    public IKAnalyzer(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    protected TokenStreamComponents createComponents(String s) {
        Tokenizer tokenizer = new IKTokenizer(configuration);
        return new TokenStreamComponents(tokenizer);
    }
}
