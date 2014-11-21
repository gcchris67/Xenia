<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:key name="hash" match="cd" use="title"/>

  <xsl:template match="/">
    ---<xsl:value-of select="catalog/cd[4]/artist"/>
    ------id of artist #2:<xsl:value-of select="generate-id(catalog/cd[4]/artist)"/>
    ---
+++++++++++++++++++++++++++++++++++++
    <xsl:for-each select="catalog/cd[generate-id()=generate-id(key('hash',title)[1])]">
    ++<xsl:value-of select="text()"/>+++<xsl:value-of select="title/@a"/>
    ++++id of cd=<xsl:value-of select="generate-id()"/>
    #title=<xsl:value-of select="title"/>
    #id of 1st artist=<xsl:value-of select="generate-id(key('hash',title)[1])"/>
    #id of 2nd artist=<xsl:value-of select="generate-id(key('hash',title)[2])"/>
-----------------------------------
-</xsl:for-each>
  </xsl:template>
</xsl:stylesheet>