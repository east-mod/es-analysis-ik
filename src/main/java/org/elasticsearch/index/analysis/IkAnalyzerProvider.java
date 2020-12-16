package org.elasticsearch.index.analysis;

import org.analyzer.config.Configuration;
import org.analyzer.lucene.IKAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.indices.analysis.AnalysisModule;

import java.io.IOException;

public class IkAnalyzerProvider extends AbstractIndexAnalyzerProvider<IKAnalyzer> {

    private final IKAnalyzer ikAnalyzer;

    public IkAnalyzerProvider(IndexSettings indexSettings,
                              Environment environment,
                              String name,
                              Settings settings,
                              boolean useSmart) {
        super(indexSettings, name, settings);
        Configuration configuration = new Configuration(environment, settings).setUseSmart(useSmart);
        this.ikAnalyzer = new IKAnalyzer(configuration);
    }

    @Override
    public IKAnalyzer get() {
        return this.ikAnalyzer;
    }

    public static class AnalysisProvider implements
            AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>> {

        @Override
        public AnalyzerProvider<? extends Analyzer> get(IndexSettings indexSettings,
                                                        Environment environment,
                                                        String name,
                                                        Settings settings) throws IOException {
            return new IkAnalyzerProvider(indexSettings, environment, name, settings, false);
        }

    }

    public static class SmartAnalysisProvider implements
            AnalysisModule.AnalysisProvider<AnalyzerProvider<? extends Analyzer>> {

        @Override
        public AnalyzerProvider<? extends Analyzer> get(IndexSettings indexSettings,
                                                        Environment environment,
                                                        String name,
                                                        Settings settings) throws IOException {
            return new IkAnalyzerProvider(indexSettings, environment, name, settings, true);
        }

    }
}
