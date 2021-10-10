package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;



    @Override
    public List<Video> listVideo() {

        return videoMapper.listVideo();
    }



    @Override
    public List<VideoBanner> listBanner() {
        return videoMapper.listVideoBanner();
    }




    @Override
    public Video findDetailById(int videoId) {

        // 需要使用mybaits关联复杂查询
        Video video = videoMapper.findDetailById(videoId);

        return video;
    }
}
