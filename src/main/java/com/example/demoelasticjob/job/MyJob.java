package com.example.demoelasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@ElasticSimpleJob(cron = "*/3 * * * * ?", shardingTotalCount = 1, shardingItemParameters = "0=A", dataSource = "dataSource")
@Component
public class MyJob implements SimpleJob {

    @Override
    public void execute(ShardingContext sc) {
        log.info(sc.getShardingParameter());
    }

}
