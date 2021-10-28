package com.kh.spring.common.batch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BaseballBatch {
   
   Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
   private BatchRepository batchRepository;
   
   
   //cron ǥ����
   //�� �� �� �� �� ���� ��(������������ ������)
   // * : ���
   // , : ���� ���� ����
   // ���۽ð�/���� : ���۽ð����� ������ �������� ����
   // 0 0 3 * * * => ���� ���� 3�ÿ� ��ġ�� ����
   // 0 0 3,6,22 * * * => ���� ���� 3��, ��ħ 6��, �� 10�ÿ� ��ġ�� ����
   // 0 0/15 * * * * => 15�и��� ��ġ�� ����
   @Scheduled(cron ="0 56/2 * * * *")
   public void baseballRankBatch(){
      try {
         Document doc = Jsoup.connect("https://www.koreabaseball.com/TeamRank/TeamRank.aspx").get();
         Elements teamList = doc.select("#cphContents_cphContents_cphContents_udpRecord > table > tbody > tr");
         List<Map<String,String>> dataList = getRankDataList(teamList);
         for (Map<String, String> map : dataList) {
            batchRepository.insertBaseballRank(map);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      logger.debug("���� �����̽��ϴ�.");
   }
   
   private List<Map<String,String>> getRankDataList(Elements teamList){
      String[] keyArr = {"rank","name","game","win","lose","tie"};
      List<Map<String,String>> dataList = new ArrayList<>();
      
      for (Element team : teamList) {
         Elements datas  =  team.getElementsByTag("td");
         Map<String,String> data = new HashMap<>();
         
         for (int i = 0; i < 6; i++) {
            data.put(keyArr[i], datas.get(i).text());
         }
         dataList.add(data);
      }
      return dataList;
   }
   
}