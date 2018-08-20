package com.tyb.fishhost.depend;

import org.springframework.stereotype.Component;

@Component
public class ComputeServiceFallBackImpl implements IComputeService
{
    @Override
    public Integer add(Integer a, Integer b) {
        return -100;
    }
}
