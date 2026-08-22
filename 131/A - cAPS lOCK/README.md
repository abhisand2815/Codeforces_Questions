<h2><a href="https://codeforces.com/contest/131/problem/A" target="_blank" rel="noopener noreferrer">131A — cAPS lOCK</a></h2>

| | |
|---|---|
| **Difficulty** | 1000 |
| **Language** | Java 21 |
| **Verdict** | ✅ Accepted |
| **Problem Link** | [Codeforces 131A](https://codeforces.com/contest/131/problem/A) |

## Topics
`implementation` `strings`

---

## Problem Statement

<div class="header"><div class="title">A. cAPS lOCK</div><div class="time-limit"><div class="property-title">time limit per test</div>0.5 second</div><div class="memory-limit"><div class="property-title">memory limit per test</div>256 megabytes</div><div class="input-file input-standard" style="font-weight: bold"><div class="property-title">input</div>stdin</div><div class="output-file output-standard" style="font-weight: bold"><div class="property-title">output</div>stdout</div></div><div><p>wHAT DO WE NEED cAPS LOCK FOR?</p><p>Caps lock is a computer keyboard key. Pressing it sets an input mode in which typed letters are capital by default. If it is pressed by accident, it leads to accidents like the one we had in the first passage. </p><p>Let's consider that a word has been typed with the Caps lock key accidentally switched on, if: </p><ul> <li> either it only contains uppercase letters; </li><li> or all letters except for the first one are uppercase. </li></ul><p>In this case we should automatically change the case of all letters. For example, the case of the letters that form words "<span class="tex-font-style-tt">hELLO</span>", "<span class="tex-font-style-tt">HTTP</span>", "<span class="tex-font-style-tt">z</span>" should be changed.</p><p>Write a program that applies the rule mentioned above. If the rule cannot be applied, the program should leave the word unchanged.</p></div><div class="input-specification"><div class="section-title">Input</div><p>The first line of the input data contains a word consisting of uppercase and lowercase Latin letters. The word's length is from 1 to 100 characters, inclusive.</p></div><div class="output-specification"><div class="section-title">Output</div><p>Print the result of the given word's processing.</p></div><div class="sample-tests"><div class="section-title">Examples</div><div class="sample-test"><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id006806685935529035" id="id007388523760101763" class="input-output-copier">Copy</div></div><pre id="id006806685935529035">cAPS<br></pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id0004791442598027862" id="id002612635144398575" class="input-output-copier">Copy</div></div><pre id="id0004791442598027862">Caps</pre></div><div class="input"><div class="title">Input<div title="Copy" data-clipboard-target="#id008841317995209563" id="id008947785820086557" class="input-output-copier">Copy</div></div><pre id="id008841317995209563">Lock<br></pre></div><div class="output"><div class="title">Output<div title="Copy" data-clipboard-target="#id0010131857413585343" id="id004191540913993107" class="input-output-copier">Copy</div></div><pre id="id0010131857413585343">Lock<br></pre></div></div></div>