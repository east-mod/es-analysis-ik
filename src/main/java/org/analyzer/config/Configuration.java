package org.analyzer.config;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;

/**
 * AUTHOR: zorigt
 * DATE  : 2020/12/15
 * WEEK  : Tue
 * TIME  : 10:09
 */
public class Configuration {

    //是否启用智能分词
    private boolean useSmart;

    public Configuration(Environment env, Settings settings) {

    }

    public Configuration setUseSmart(boolean useSmart) {
        this.useSmart = useSmart;
        return this;
    }
}
