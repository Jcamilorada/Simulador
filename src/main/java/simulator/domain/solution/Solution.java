package simulator.domain.solution;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class Solution
{
    private Long id;
    private String description;
    private int value;
}
