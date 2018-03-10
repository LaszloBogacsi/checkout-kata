package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleTest {
    @Test
    void crate_a_rule_with_valid_properties() {
        Rule rule = Rule.create(1, "ruleType", 2, 3.0);
        assertEquals(rule.getRuleId(), 1);
        assertEquals(rule.getType(), "ruleType");
        assertEquals(rule.getMinQuantityToQualify(), 2);
        assertEquals(rule.getNewPrice(), 3.0);
    }
}