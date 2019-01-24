package net.alex9849.arm.regions;

import net.alex9849.arm.Messages;

public enum SellType {
    SELL {
        public String getName() {
            return Messages.SELLREGION_NAME;
        }
    }, RENT {
        public String getName() {
            return Messages.RENTREGION_NAME;
        }
    }, CONTRACT {
        public String getName() {
            return Messages.CONTRACTREGION_NAME;
        }
    };

    public abstract String getName();

    public static SellType getSelltype(String string) {
        if (string.equalsIgnoreCase("sellregion")) {
            return SellType.SELL;
        } else if (string.equalsIgnoreCase("rentregion")) {
            return SellType.RENT;
        } else if (string.equalsIgnoreCase("contractregion")) {
            return SellType.CONTRACT;
        }
        return null;
    }

}
