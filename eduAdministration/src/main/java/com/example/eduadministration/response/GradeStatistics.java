package com.example.eduadministration.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成绩统计结果模型
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradeStatistics {


    /**
     * 学生总数
     */
    private int studentNum;

    /**
     * 平均分
     */
    private double averageScore;

    /**
     * 最高分
     */
    private double highestScore;

    /**
     * 及格率
     */
    private double passedRate;

    /**
     * 优秀率
     */
    private double excellentRate;
}
