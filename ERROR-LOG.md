# 错题本（ERROR-LOG）

> 规则：每抓到一个真实 bug 或概念错误，记一条：症状 → 根因 → 正确写法。
> 每周日复盘 15 分钟：通读一遍，每条不看答案手敲一遍正确写法。
> 首场复盘：2026-10-25（周日）。这个本子和 commit 记录一样，都是简历的素材。

## 1. 相对路径 `../` 多跳一级（Day2 · 10-20）
- **症状**：text2/text3 的图片、视频全部裂图
- **错误代码**：`src="../素材库/图片/img1.jpg"`
- **根因**：素材库实际建在 `HTML-CSS/` 里面，与 html 同级；`../` 是从当前 html 所在目录**往上跳一级**，多跳了
- **正确写法**：`src="素材库/图片/img1.jpg"`
- **教训**：写相对路径前，先确认目标文件到底在哪一级；`../` 不是万金油

## 2. label 行三连错（Day3 · 10-21 凌晨，表单标签.html 密码行）
- **症状**：表单结构错乱，密码 label 关联失效
- **错误代码**：`<label for="password"></label>密码:</label><input type="password" ... placeholder="请输入密码"required>`
- **三个错**：① 空 label（for 指向了没有任何内容的 label）② 多余的闭合标签 `</label>`（没有对应开标签）③ `"请输入密码"required` 两个属性之间缺空格
- **正确写法**：`<label for="password">密码:</label><input type="password" id="password" name="password" placeholder="请输入密码" required>`
- **教训**：改一整行时整行替换，不要在行中间拼接；属性之间永远留空格

## 3. `</dic>` 手滑（Day3-extra · 10-21 凌晨，顶部导航栏.html）
- **症状**：整个 container div 没有正确闭合，页面结构断裂
- **错误代码**：`</footer></dic>`
- **正确写法**：`</footer></div>`
- **教训**：保存前扫一眼闭合标签配对；闭合标签打错字母，浏览器不会报错，只会默默显示错乱

## 4. `margin-bottom` 双值（Day3-extra · 10-21 凌晨）
- **症状**：搜索表单与下方内容的间距完全不生效
- **错误代码**：`margin-bottom: 20px 0;`
- **根因**：`margin-bottom` 只接受**一个**值；写了两个值，整条声明被浏览器丢弃
- **正确写法**：`margin: 20px 0;`（简写）或 `margin-bottom: 20px;`
- **教训**：单边属性（margin-top/bottom/left/right）只吃一个值；多边距用 margin/padding 简写

## 5. 概念错误：以为 POST 不能传多个参数（Day3 · 10-21）
- **错误认知**：post 请求不能用 `&` 分隔多个参数
- **事实**：POST 照样能传多个参数，也是 `&` 分隔；区别只在于 GET 的参数拼在 URL 上，POST 的参数放在**请求体**里
- **关联**：GET 不能传文件/敏感信息（URL 可见），POST 可以——这才是两者的本质区别

## 6. for/id 学了没滚上（Day3-extra · 10-21）
- **症状**：Day3 刚练过 `label for` + `id` 关联，第二天写搜索表单时又全用裸文本前缀，关联断掉
- **教训**：学到 ≠ 学会；学会的标准是**没人提醒时你也用**。每次写表单，先问自己：label 关联了吗？

## 7. `:key` 绑了数据里不存在的字段（Day5 · 10-23 凌晨，vue/练习.html）
- **症状**：v-for 每行的 key 全是 undefined，Vue 更新列表时可能报 duplicate key 警告、渲染错乱
- **错误代码**：`:key="item.id"`，而 empList 三条数据里根本没有 id 字段（只有 name/gender/avatar/job/hireDate/lastOpTime）
- **根因**：key 的职责是给每一行一个唯一标识；绑了个不存在的字段，等于没绑
- **正确写法**：给数据补 `id: 1 / id: 2 / id: 3`（与课程原版数据对齐），或退一步 `:key="index"`
- **教训**：写完 v-for 先回头看一眼——`:key` 绑的字段，数据里到底有没有

## 8. HTML 里写 `//` 伪注释（Day5 · 10-23 凌晨，vue/练习.html）
- **症状**：表格上方莫名其妙多出两行文字："//v-if指令""//v-show指令"
- **错误代码**：`<tr>` 里面直接写 `//v-if指令`
- **根因**：`//` 是 JS 注释，HTML 不认；`<tr>` 里的裸文本会被浏览器 foster parenting 扔到表格外面显示
- **正确写法**：HTML 注释只用 `<!-- -->`，或者干脆删掉
- **教训**：JS 的注释语法不能带进 HTML；table 结构里尤其明显——多出来的文本会被扔到表格上方

---
*记录人：ThePang 的助教 · 本子与 commit 记录同在，是成长的硬证据*
