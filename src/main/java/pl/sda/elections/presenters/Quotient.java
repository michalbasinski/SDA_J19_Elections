package pl.sda.elections.presenters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Quotient {
    private int n;
    private Long value;
    private Long listId;
}