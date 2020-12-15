package org.elasticsearch;

import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;

public class IkTokenizerFactory extends AbstractTokenizerFactory {
    public IkTokenizerFactory(IndexSettings indexSettings, Settings settings, String name) {
        super(indexSettings, settings, name);
    }

    @Override
    public Tokenizer create() {
        return null;
    }
}
