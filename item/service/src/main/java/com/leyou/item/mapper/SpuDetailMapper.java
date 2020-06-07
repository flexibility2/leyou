package com.leyou.item.mapper;

import com.leyou.item.domain.SpuDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpuDetailMapper {

    int insertSpuDetails(SpuDetail spuDetail);

}
