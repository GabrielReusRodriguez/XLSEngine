<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="2.0" xmlns:fn="http://www.w3.org/2005/xpath-functions"
  xmlns:gdt="http://www.gdt.com">
  
  <xsl:template match="@*|node()">
    <xsl:copy>
      <xsl:apply-templates select="@*|node()"/>
    </xsl:copy>
  </xsl:template>
  
  <xsl:template match="/gdt:line">
  	<xsl:value-of select="fn:substring-before(.,' ')"/>
  </xsl:template>
  
</xsl:stylesheet>