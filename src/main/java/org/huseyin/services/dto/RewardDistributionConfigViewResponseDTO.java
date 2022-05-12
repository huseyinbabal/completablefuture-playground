package org.huseyin.services.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RewardDistributionConfigViewResponseDTO {

   private int cashConfig;

   private int exclusiveConfig;

   private int partnerConfig;

   private int rebateConfig;

}
