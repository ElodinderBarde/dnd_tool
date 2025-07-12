package ch.Elodin.DnD_Tool.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopItemDTO {
    private Integer shopItemId;
    private Integer shopId;
    private Integer itemId;
    private Integer quantity;
    private ItemDTO item;
}
