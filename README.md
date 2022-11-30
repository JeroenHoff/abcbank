<div>
<h1>ABC Bank Customer Statement Processor</h1>
</div>
<div>
<div>
<div>
<div>
<p>ABC Bank receives monthly deliveries of customer statement records. This information is delivered in three formats CSV, XML. These records need to be validated.</p>
</div>
</div>
</div>
<div>
<h2>Input</h2>
<div>
<div>
<p>The format of the file is a simplified version of the MT940 format. The format is as follows:</p>
</div>
<table>
<thead>
<tr>
<th>Field</th>
<th>Description</th>
</tr>
</thead>
<tbody>
<tr>
<td><p>Transaction reference</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">A numeric value</p></td>
</tr>
<tr>
<td><p class="tableblock">Account number</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">An IBAN</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">Start Balance</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">The starting balance in Euros</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">Mutation</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Either an addition (+) or a deduction (-)</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">Description</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">Free text</p></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><p class="tableblock">End Balance</p></td>
<td class="tableblock halign-left valign-top"><p class="tableblock">The end balance in Euros</p></td>
</tr>
<tr>
    <td class="tableblock halign-left valign-top"><p class="tableblock">Transaction Date</p></td>
    <td class="tableblock halign-left valign-top"><p class="tableblock">Date in the format: yyyy-mm-dd</p></td>
    </tr>
</tbody>
</table>
</div>
</div>
<div class="sect1">
<h2 id="_output">Output</h2>
<div class="sectionbody">
<div class="paragraph">
<p>There are four validations:</p>
</div>
<div class="ulist">
<ul>
<li>
<p>all transaction references should be unique</p>
</li>
<li>
<p>the end balance needs to be validated</p>
</li>
<li>
<p>The start & end balances in the input data should be greater than or equal to 0</p>
</li>
<li>
    <p>Transaction Date should not be a future date</p>
</li>
</ul>
</div>
<div class="paragraph">
<p>At the end of the processing, a report needs to be created which will display both the transaction reference and description of each of the failed records.</p>

<p>A sample csv(records.csv) & xml(records.xml) file can also be found in this repo!
</p>
</div>
</div>
</div>
</div>