<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions"
	exclude-result-prefixes="xs">
	<xsl:param name="date">
		2013-11-04+11:00
	</xsl:param>
	<xsl:param name="time">
		16:09:24.123+11:00
	</xsl:param>
	<xsl:variable name="dateTime" select="concat($date,'T',$time)" />
	
	
	<xsl:template match="/">
		<html>
			<body>
				<h1>Formatting Dates with XSLT 2.0</h1>
				<p>
					Date:
					<xsl:value-of select="$date" />
				</p>
				<p>
					Time:
					<xsl:value-of select="$time" />
				</p>
				<p>
					DateTime:
					<xsl:value-of select="$dateTime" />
				</p>
				<br />
				<br />
				<table border="1">
					<tr>
						<th>Description</th>
						<th>Code</th>
						<th>Result</th>
					</tr>
					<tr>
						<td>XML Format</td>
						<td>
							<pre>n/a</pre>
						</td>
						<td>
							<xsl:value-of select="$date" />
						</td>
					</tr>
					<tr>
						<td>YYYYMMDD</td>
						<td>
							<pre>format-date($date,'[Y0001][M01][D01]')</pre>
						</td>
						<td>
							<xsl:value-of select="fn:format-date($date,'[Y0001][M01][D01]')" />
						</td>
					</tr>
					<tr>
						<td>In English</td>
						<td>
							<pre>format-date($date,'The [D1o] of [MNn], [YWw]')</pre>
						</td>
						<td>
							<xsl:value-of select="format-date($date,'The [D1o] of [MNn], [YWw]')" />
						</td>
					</tr>
					<tr>
						<td>Auf Deutsch</td>
						<td>
							<pre>format-date($date,'[D1o] [MNn] [Y0001]','de','AD','DE')
							</pre>
						</td>
						<td>
							<xsl:value-of
								select="format-date($date,'[D1o] [MNn] [Y0001]','de','AD','DE')" />
						</td>
					</tr>
					<tr>
						<td>Roman</td>
						<td>
							<pre>format-date($date,'[Di] [MI] [YI]')</pre>
						</td>
						<td>
							<xsl:value-of select="format-date($date,'[Di] [MI] [YI]')" />
						</td>
					</tr>
					<tr>
						<td>Long example</td>
						<td>
							<pre>format-date($date,'The [D1o] day of [MNn] in [Y0001] [E] is
								the [d1o] day of the year.')</pre>
						</td>
						<td>
							<xsl:value-of
								select="format-date($date,'The [D1o] day of [MNn] in [Y0001] [E] is the [d1o] day of the year.')" />
						</td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>