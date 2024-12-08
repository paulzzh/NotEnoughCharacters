please build
# Not Enough Characters

一个改进 1.7.10 中 NEI 搜索功能的 mod，让 NEI 支持拼音搜索与 JEI 风格的关键字匹配

当前版本在原来的基础上添加了NEI以外的拼音搜索兼容 ，使其更类似于[JustEnoughCharacters](https://github.com/Towdium/JustEnoughCharacters) ，

目前支持的Mod有：

`Applied Energistics 2`

`Extra Cells 2`

`Wireless Crafting Terminal`

`Steve's Factory Manager`

`Witching Gadgets提供的魔导手册搜索`

`GTNH版本Better Questing添加的任务搜索`

`Just Enough Calculation`

`Logistics Pipes`


## 主要功能

- 用全拼、首字母混合搜索汉字，如「夜视药水」可用 `yshiysh` 搜索到
- 用空格分割搜索关键字，各关键字之间是「与」逻辑关系，如「喷溅型夜视药水」可用 `ysys pjx` 搜索到
- `@` 前缀的关键字匹配物品所属的 mod，如匠魂中的「混凝土」可用 `@tcon hnt` 搜索到
- `$` 前缀的关键字匹配矿物辞典，如所有的 GT 热金属锭可用 `$ingothot` 搜索到
- `&` 前缀的关键字匹配物品 ID
- 添加了模糊音的配置文件
- 添加了大千注音和小鹤/自然码双拼键盘选项的配置文件
- 可以在配置文件来添加对应mod的兼容(基于[JustEnoughCharacters](https://github.com/Towdium/JustEnoughCharacters))

## 注意事项

此 mod 仅在 GT New Horizons 整合包开发者 fork 的 [NEI 2.0](https://github.com/GTNewHorizons/NotEnoughItems) 上测试过。理论上也应该支持原版 NEI 1.x，但不作保证。

推荐原版 NEI 用户升级至上述的修改版 NEI，因为它极大地提升了 NEI 的搜索性能，并且移植了一些 JEI 的功能进来。

虽然此修改版本添加了别的mod兼容，但是它还是需要NEI

## 鸣谢

此 mod 的核心功能基于 [JustEnoughCharacters](https://github.com/Towdium/JustEnoughCharacters) 的作者开发的拼音匹配工具 [PinIn](https://github.com/Towdium/PinIn)。

PinIn 实现了一套基于 NFA 的拼音匹配算法……算了，我没有这方面的知识，而且词穷，反正就是：非常智能！性能很好！吹爆！

ASM部分基于Towdium的[JustEnoughCharacters](https://github.com/Towdium/JustEnoughCharacters)

## 协议

此项目是采用 GNU General Public License v3 or later 协议的自由软件。
