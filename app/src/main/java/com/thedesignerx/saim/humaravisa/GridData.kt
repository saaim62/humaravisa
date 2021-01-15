package saim.com.ButtSweets.activities.main

import com.thedesignerx.saim.humaravisa.Quote
import com.thedesignerx.saim.humaravisa.R
import java.util.ArrayList

class GridData{
    val data: ArrayList<Quote>
        get() {
            val quotes = ArrayList<Quote>()

            val quoteCake = Quote("CAKES", R.drawable.cake)
            quotes.add(quoteCake)

            val quoteSweets = Quote("SWEETS",R.drawable.sweet)
            quotes.add(quoteSweets)

            val quoteHalwajaat = Quote("HALWAJAAT",R.drawable.halwa)
            quotes.add(quoteHalwajaat)

            val quoteSamosa = Quote("SAMOSA",R.drawable.samosa)
            quotes.add(quoteSamosa)

            val quoteInstantbake = Quote("INSTANT BAKED",R.drawable.instentbake)
            quotes.add(quoteInstantbake)

            val quoteTVC = Quote("TVC'S", R.drawable.tvc)
            quotes.add(quoteTVC)

            val quoteCake2 = Quote("CAKES",R.drawable.cake)
            quotes.add(quoteCake2)

            val quoteSweets2 = Quote("SWEETS",R.drawable.sweet)
            quotes.add(quoteSweets2)

            val quoteHalwajaat2 = Quote("HALWAJAAT",R.drawable.halwa)
            quotes.add(quoteHalwajaat2)

            val quoteSamosa2 = Quote("SAMOSA",R.drawable.samosa)
            quotes.add(quoteSamosa2)

            val quoteInstantbake2 = Quote("INSTANT BAKED",R.drawable.instentbake)
            quotes.add(quoteInstantbake2)

            val quoteTVC2 = Quote("TVC'S",R.drawable.tvc)
            quotes.add(quoteTVC2)

            return quotes
        }
}
