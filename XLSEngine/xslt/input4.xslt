<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="first">
    <first>
<!--         <xsl:value-of select="substring-before(.,' ')" /> -->
			<xsl:value-of select="substring(.,2)" />
    </first>
</xsl:template> 
<xsl:template match="last">
    <last>
        <xsl:value-of select="substring-after(.,' ')" />
    </last>
</xsl:template> 
<xsl:template match="@* | node()">
    <xsl:copy>
        <xsl:apply-templates select="@* | node()" />
    </xsl:copy>
</xsl:template>
</xsl:stylesheet>