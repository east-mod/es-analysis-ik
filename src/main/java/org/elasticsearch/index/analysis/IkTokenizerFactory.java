package org.elasticsearch.index.analysis;

import org.analyzer.config.Configuration;
import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.indices.analysis.AnalysisModule;

import java.io.IOException;

public class IkTokenizerFactory extends AbstractTokenizerFactory {

    private final Configuration configuration;

    public IkTokenizerFactory(IndexSettings indexSettings, Environment environment, Settings settings, String name) {
        super(indexSettings, settings, name);
        configuration = new Configuration(environment, settings);
    }

    public IkTokenizerFactory setSmart(boolean smart) {
        this.configuration.setUseSmart(smart);
        return this;
    }

    @Override
    public Tokenizer create() {
        return null;
    }


    public static class AnalysisProvider implements AnalysisModule.AnalysisProvider<TokenizerFactory> {
        @Override
        public TokenizerFactory get(IndexSettings indexSettings,
                                    Environment environment,
                                    String name,
                                    Settings settings) throws IOException {
            return new IkTokenizerFactory(indexSettings, environment, settings, name).setSmart(true);
        }
    }

    public static class SmartAnalysisProvider implements AnalysisModule.AnalysisProvider<TokenizerFactory> {
        @Override
        public TokenizerFactory get(IndexSettings indexSettings,
                                    Environment environment,
                                    String name,
                                    Settings settings) throws IOException {
            return new IkTokenizerFactory(indexSettings, environment, settings, name).setSmart(false);
        }
    }
}
