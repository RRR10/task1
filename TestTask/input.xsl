<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="node() | @*">
		<xsl:copy>
			<xsl:apply-templates select="node() | @*" />
		</xsl:copy>
	</xsl:template>
	<xsl:key name="bycountry" match="Person" use="Country" />
	<xsl:template match="Persons">
		<Countries>
			<xsl:for-each select="Person[count(. | key('bycountry', Country)[1]) = 1]">
				<Country>
					<xsl:attribute name="name">
						<xsl:value-of select="Country" />
					</xsl:attribute>
					<xsl:attribute name="personCount">
						<xsl:value-of select="count(key('bycountry', Country))" />
					</xsl:attribute>
					<Names>
						<xsl:for-each select="key('bycountry', Country)">
							<Name>
								<xsl:value-of select="Name" />
							</Name>
						</xsl:for-each>
					</Names>
				</Country>
			</xsl:for-each>
		</Countries>
	</xsl:template>
</xsl:stylesheet>