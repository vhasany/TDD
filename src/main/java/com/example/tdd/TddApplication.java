package com.example.tdd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@SpringBootApplication
public class TddApplication {
  static WalletChange wallet;


  public static void main(String[] args) {
    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneOffset.UTC);
    System.out.println(zonedDateTime.toEpochSecond());
    zonedDateTime=zonedDateTime.minusDays(7);
    System.out.println(zonedDateTime.toEpochSecond());
  }

  public static WalletChange walletOfflineChange(int gem) {
    gem = -Math.abs(gem);

    if (wallet.getGem() < gem) {
      throw new IllegalArgumentException();
    }

    if (wallet.getGem() + gem < 0) {
      gem = 0;
    }

    wallet.gem += gem;
    // TODO: 4/16/22 remove after debug
    if (wallet.getGem() < 0) {
      System.out.println("negative gem detected! value" + wallet.gem);
    }
    return WalletChange.builder().gem(gem).build();
  }

  @Data
  @AllArgsConstructor
  @Builder
  static class WalletChange {
    private int gem;
  }
}
