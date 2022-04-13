package br.com.alura.dojoadopt.animal;

import java.math.BigDecimal;

public interface MonthlyExpensesByOwnerProjection {
    BigDecimal getMonthlyTotalExpenses();
    String getOwnerName();
}
