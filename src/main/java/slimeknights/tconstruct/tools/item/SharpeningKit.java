package slimeknights.tconstruct.tools.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.Util;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.ToolMaterialStats;
import slimeknights.tconstruct.library.tools.ToolPart;

public class SharpeningKit extends ToolPart {

  public SharpeningKit() {
    super(Material.VALUE_Shard*3);
  }

  @Override
  public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
    // this adds a variant of each material to the creative menu
    for(Material mat : TinkerRegistry.getAllMaterials()) {
      subItems.add(getItemstackWithMaterial(mat));
    }
  }

  @Override
  public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
    tooltip.addAll(Util.getTooltips(Util.translate("item.tconstruct.sharpening_kit.tooltip")));
    if(!checkMissingMaterialTooltip(stack, tooltip)) {
      Material material = getMaterial(stack);
      ToolMaterialStats stats = material.getStats(ToolMaterialStats.TYPE);
      tooltip.add(ToolMaterialStats.formatHarvestLevel(stats.harvestLevel));
    }
  }
}
