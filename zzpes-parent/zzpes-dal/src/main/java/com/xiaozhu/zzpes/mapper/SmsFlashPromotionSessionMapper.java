package com.xiaozhu.zzpes.mapper;

import com.xiaozhu.zzpes.entity.SmsFlashPromotionSession;
import com.xiaozhu.zzpes.entity.SmsFlashPromotionSessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFlashPromotionSessionMapper {
    long countByExample(SmsFlashPromotionSessionExample example);

    int deleteByExample(SmsFlashPromotionSessionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsFlashPromotionSession record);

    int insertSelective(SmsFlashPromotionSession record);

    List<SmsFlashPromotionSession> selectByExample(SmsFlashPromotionSessionExample example);

    SmsFlashPromotionSession selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    int updateByExample(@Param("record") SmsFlashPromotionSession record, @Param("example") SmsFlashPromotionSessionExample example);

    int updateByPrimaryKeySelective(SmsFlashPromotionSession record);

    int updateByPrimaryKey(SmsFlashPromotionSession record);
}