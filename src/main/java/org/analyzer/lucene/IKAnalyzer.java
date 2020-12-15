package org.analyzer.lucene;

import org.apache.lucene.analysis.Analyzer;

/**
 * AUTHOR: zorigt
 * DATE  : 2020/12/15
 * WEEK  : Tue
 * TIME  : 10:08
 */
public class IKAnalyzer extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String s) {
        return null;
    }
}
