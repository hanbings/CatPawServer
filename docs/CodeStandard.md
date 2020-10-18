### **0x00: GitHub项目地址:** https://github.com/hanbings/CatPawServer

~~假装这不是4维隔壁群的规范~~

### 0x01: 编写规范遵循 阿里巴巴Java规范

详细规则文档在群文件 *技术部文档与资源 文件夹内 

### 0x02: 类与方法注释遵循JavaDoc格式

```java
类：
/**
 \* description
 \* @author xxx
 */
方法：
/** 
 \* description
 \* @author xxx
 \* @param
 \* @return
 */
```

以上为固定的注释结构
其余未提到JavaDoc标记符均可追加

### 0x03: GitHub项目内关键字:

Type: Comment / PR
Type：**Feat（新内容）、Fix（修复）、Refact（重构）、Docs（文档）、Style（格式）、Chore（构建变动等）、Test（测试）**

推荐在Commit类型前加图标以标识类型
**类型图标**参示：https://blog.csdn.net/qq_35781178/article/details/103426710

| emoji名称    | emoji                      | Commit / PR 说明      |
| ------------ | -------------------------- | --------------------- |
| (庆祝)       | :tada:                     | 初次提交              |
| (火花)       | :sparkles:                 | 引入新功能            |
| (书签)       | :bookmark:                 | 发行/版本标签         |
| (bug)        | :bug:                      | 修复 bug              |
| (急救车)     | :ambulance:                | 重要补丁              |
| (地球)       | :globe_with_meridians:     | 国际化与本地化        |
| (口红)       | :lipstick:                 | 更新 UI 和样式文件    |
| (警车灯)     | :rotating_light:           | 移除 linter 警告      |
| (扳手)       | :wrench:                   | 修改配置文件          |
| (加号)       | :heavy_plus_sign:          | 增加一个依赖          |
| (减号)       | :heavy_minus_sign:         | 减少一个依赖          |
| (上升箭头)   | :arrow_up:                 | 升级依赖              |
| (下降箭头)   | :arrow_down:               | 降级依赖              |
| (闪电)       | :zap:                      | 提升性能              |
| (赛马)       | :racehorse:                | 提升性能              |
| (上升趋势图) | :chart_with_upwards_trend: | 添加分析或跟踪代码    |
| (火箭)       | :rocket:                   | 部署功能              |
| (白色复选框) | :white_check_mark:         | 增加测试              |
| (备忘录)     | :memo:                     | 撰写文档              |
| (锤子)       | :hammer:                   | 重大重构              |
| (调色板)     | :art:                      | 改进代码结构/代码格式 |
| (火焰)       | :fire:                     | 移除代码或文件        |
| (铅笔)       | :pencil2:                  | 修复 typo             |
| (施工)       | :construction:             | 工作进行中            |
| (工人)       | :construction_worker:      | 添加 CI 构建系统      |
| (绿心)       | :green_heart:              | 修复 CI 构建问题      |
| (锁)         | :lock:                     | 修复安全问题          |
| (鲸鱼)       | :whale:                    | Docker 相关工作       |
| (苹果)       | :apple:                    | 修复 macOS 下的问题   |
| (企鹅)       | :penguin:                  | 修复 Linux 下的问题   |
| (旗帜)       | :checkered_flag:           | 修复 Windows 下的问题 |

示例
Commit: ​ :bug: Fix: fix some bug
Description: anythings