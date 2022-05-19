package org.eadge.extractpdfexcel.data.block;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.DocumentFont;
import org.eadge.extractpdfexcel.data.geom.Rectangle2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * <p/>
 * Holds text and bounds.
 */
public class Block
{
    private String formattedText;
    private String originalText;

    private Rectangle2 bound;

    private Direction textOrientation;
    private Direction blockOrientation;

    private Set<BaseColor> fontColors;
    private Set<BaseColor> backColors;
    private Set<DocumentFont> fonts;


    private Block prev = null;
    private Block next = null;

    public Block(String originalText, Rectangle2 bound)
    {
        this.originalText = originalText;
        this.formattedText = originalText;

        this.bound = bound;

        this.blockOrientation = null;

        this.blockOrientation = Direction.LEFT;
        this.textOrientation = Direction.LEFT;

        this.backColors = new HashSet<>();
        this.fontColors = new HashSet<>();
        this.fonts = new HashSet<>();
    }

    public Block(String originalText,
                 Rectangle2 bound,
                 Direction blockOrientation,
                 Direction textOrientation,
                 Set<BaseColor> fontColors,
                 Set<BaseColor> backColors,
                 Set<DocumentFont> fonts)
    {
        this.originalText = originalText;
        this.formattedText = originalText;

        this.bound = bound;

        this.blockOrientation = blockOrientation;
        this.textOrientation = textOrientation;

        this.fontColors = fontColors;
        this.backColors = backColors;

        this.fonts = fonts;
    }

    /*
     * Getter and setter
     */
    public Direction getTextOrientation()
    {
        return textOrientation;
    }

    public void setTextOrientation(Direction textOrientation)
    {
        this.textOrientation = textOrientation;
    }

    public String getFormattedText()
    {
        return formattedText;
    }

    public void setFormattedText(String formattedText)
    {
        this.formattedText = formattedText;
    }

    public String getOriginalText()
    {
        return originalText;
    }

    public void setOriginalText(String originalText)
    {
        this.originalText = originalText;
    }

    public Rectangle2 getBound()
    {
        return bound;
    }

    public void setBound(Rectangle2 bound)
    {
        this.bound = bound;
    }

    public void setPos(int i, double value) { bound.setPos(i, value); }

    public double getPos(int i) { return bound.getPos(i); }

    public void setLength(int i, double value) { bound.setLength(i, value); }

    public double getLength(int i) { return bound.getLength(i); }

    public Set<DocumentFont> getFonts()
    {
        return fonts;
    }

    public boolean containFonts(DocumentFont font)
    {
        return fonts.contains(font);
    }

    public Set<BaseColor> getFontColors()
    {
        return fontColors;
    }

    public boolean containFontColor(BaseColor fontColor)
    {
        return fontColors.contains(fontColor);
    }

    public void setFontColor(Set<BaseColor> fontColor)
    {
        this.fontColors = fontColor;
    }

    public Set<BaseColor> getBackColors()
    {
        return backColors;
    }

    public void setBackColors(Set<BaseColor> backColors)
    {
        this.backColors = backColors;
    }

    public boolean containBackColor(BaseColor backColor)
    {
        return backColors.contains(backColor);
    }

    public Direction getBlockOrientation()
    {
        return blockOrientation;
    }

    public void setBlockOrientation(Direction blockOrientation)
    {
        this.blockOrientation = blockOrientation;
    }

    public void insertStartFormatted(String formattedText)
    {
        this.formattedText = formattedText + this.formattedText;
    }

    public void insertStartOriginal(String originalText)
    {
        this.originalText = originalText + this.originalText;
    }

    public void insertEndFormatted(String formattedText)
    {
        this.formattedText += formattedText;
    }

    public void insertEndOriginal(String originalText)
    {
        this.originalText += originalText;
    }

    public void addBackColor(BaseColor backColor)
    {
        this.backColors.add(backColor);
    }

    public void addFontColor(BaseColor fontColor)
    {
        this.fontColors.add(fontColor);
    }

    public void addFont(DocumentFont font)
    {
        this.fonts.add(font);
    }

    public void addAllBackColors(Collection<BaseColor> backColors)
    {
        this.backColors.addAll(backColors);
    }

    public void addAllFontColors(Collection<BaseColor> fontColors)
    {
        this.fontColors.addAll(fontColors);
    }

    public void addAllFonts(Collection<DocumentFont> fonts)
    {
        this.fonts.addAll(fonts);
    }

    public double getMidPos(int axis)
    {
        return bound.getMidPos(axis);
    }

    public double getEndPos(int axis)
    {
        return bound.getEndPos(axis);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        if (formattedText != null ? !formattedText.equals(block.formattedText) : block.formattedText != null)
            return false;
        if (originalText != null ? !originalText.equals(block.originalText) : block.originalText != null) return false;
        if (bound != null ? !bound.equals(block.bound) : block.bound != null) return false;
        if (textOrientation != block.textOrientation) return false;
        if (blockOrientation != block.blockOrientation) return false;
        if (fontColors != null ? !fontColors.equals(block.fontColors) : block.fontColors != null) return false;
        if (backColors != null ? !backColors.equals(block.backColors) : block.backColors != null) return false;
        return fonts != null ? fonts.equals(block.fonts) : block.fonts == null;

    }

    @Override
    public int hashCode()
    {
        int result = formattedText != null ? formattedText.hashCode() : 0;
        result = 31 * result + (originalText != null ? originalText.hashCode() : 0);
        result = 31 * result + (bound != null ? bound.hashCode() : 0);
        result = 31 * result + (textOrientation != null ? textOrientation.hashCode() : 0);
        result = 31 * result + (blockOrientation != null ? blockOrientation.hashCode() : 0);
        result = 31 * result + (fontColors != null ? fontColors.hashCode() : 0);
        result = 31 * result + (backColors != null ? backColors.hashCode() : 0);
        result = 31 * result + (fonts != null ? fonts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        String text = (formattedText != null) ? formattedText : originalText;
        return "\"" + text + "\"  " + bound;
    }

    public Block getPrev()
    {
        return prev;
    }

    public void setPrev(Block prev)
    {
        this.prev = prev;
    }

    public Block getNext()
    {
        return next;
    }

    public void setNext(Block next)
    {
        this.next = next;
    }
}
