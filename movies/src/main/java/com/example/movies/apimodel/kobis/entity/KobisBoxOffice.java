package com.example.movies.apimodel.kobis.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class KobisBoxOffice {
   private boxOfficeResult boxOfficeResult;

  /*  public boxOfficeResult getBoxOfficeResult() {
      return boxOfficeResult;
   } */

   @NoArgsConstructor
   @AllArgsConstructor
   @Getter
   @Builder
   @ToString
   public static class boxOfficeResult {
      private List<DailyBoxOffice> dailyBoxOfficeList;

      
     /*  public List<DailyBoxOffice> getDailyBoxOfficeList() {
         return dailyBoxOfficeList;
      } */

      @NoArgsConstructor
      @AllArgsConstructor
      @Getter
      @Builder
      @ToString
      public static class DailyBoxOffice {
         @JsonProperty("rank")
         private int rank;

         @JsonProperty("movieNm")
         private String movieName;

      }
   }

}
