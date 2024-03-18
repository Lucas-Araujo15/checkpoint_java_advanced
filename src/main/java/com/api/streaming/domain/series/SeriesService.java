package com.api.streaming.domain.series;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;
}
