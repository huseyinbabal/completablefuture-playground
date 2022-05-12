package org.huseyin.services;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.huseyin.services.dto.RewardDistributionConfigViewResponseDTO;

public class ViewService {

    private CashConfigService cashConfigService;

    private ExclusiveConfigService exclusiveConfigService;

    private PartnerConfigService partnerConfigService;

    private RebateConfigService rebateConfigService;

    public ViewService() {
        cashConfigService = new CashConfigService();
        exclusiveConfigService = new ExclusiveConfigService();
        partnerConfigService = new PartnerConfigService();
        rebateConfigService = new RebateConfigService();
    }

    public RewardDistributionConfigViewResponseDTO getViewByRewardId(int rewardId) {
        RewardDistributionConfigViewResponseDTO dto = new RewardDistributionConfigViewResponseDTO();
        augmentRewardDistributionConfigView(dto, rewardId);
        return dto;
    }

    private void augmentRewardDistributionConfigView(RewardDistributionConfigViewResponseDTO dto, int rewardId) {
        CompletableFuture futureOne = CompletableFuture.runAsync(() -> {
            dto.setCashConfig(cashConfigService.getByRewardId(rewardId));
        });
        CompletableFuture futureTwo = CompletableFuture.runAsync(() -> {
            dto.setExclusiveConfig(exclusiveConfigService.getByRewardId(rewardId));
        });
        CompletableFuture futureThree = CompletableFuture.runAsync(() -> {
            dto.setPartnerConfig(partnerConfigService.getByRewardId(rewardId));
        });
        CompletableFuture futureFour = CompletableFuture.runAsync(() -> {
            dto.setRebateConfig(rebateConfigService.getByRewardId(rewardId));
        });
        try {
            CompletableFuture.allOf(futureOne, futureTwo, futureThree, futureFour).get();
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
