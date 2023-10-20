package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundDouble {
    /**
     * @about
     * double 타입의 value를 plcaes자리만큼 round해주는 함수
     *
     * @implNote
     * Math.pow를 사용한 round는 특정 수에서 깨지므로 BigDecimal사용하는 식으로 구현
     *
     * @reference
     * // https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
     *
     * @param value
     * @param places
     * @return
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
