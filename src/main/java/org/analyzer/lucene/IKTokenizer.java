package org.analyzer.lucene;

import org.apache.lucene.analysis.Tokenizer;

import java.io.IOException;

/**
 * AUTHOR: zorigt
 * DATE  : 2020/12/15
 * WEEK  : Tue
 * TIME  : 10:08
 */
public class IKTokenizer extends Tokenizer {
    @Override
    public boolean incrementToken() throws IOException {
        return false;
    }
}
