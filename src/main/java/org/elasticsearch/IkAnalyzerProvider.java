package org.elasticsearch;

import org.analyzer.lucene.IKAnalyzer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;

public class IkAnalyzerProvider extends AbstractIndexAnalyzerProvider<IKAnalyzer> {

    public IkAnalyzerProvider(IndexSettings indexSettings, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public IKAnalyzer get() {
        return null;
    }
}
