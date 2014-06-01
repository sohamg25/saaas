<?xml version="1.0"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
     <ReportItems>
      <xsl:for-each select="BugCollection/BugInstance">
      </xsl:for-each>
     </ReportItems>
</xsl:template>

</xsl:stylesheet> 
