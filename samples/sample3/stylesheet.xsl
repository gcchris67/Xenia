<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:key name="pspByPos_Ez" match="psp" use="concat(@pos,'_',@ez)" />

	<xsl:template match="/">
		<xsl:for-each select="project/psp[generate-id()=generate-id(key('pspByPos_Ez',concat(@pos,'_',@ez)))]" >
			<xsl:value-of select="@pos" />-<xsl:value-of select="@ez" />
		</xsl:for-each>
	</xsl:template>

</xsl:stylesheet>