package _02.notes;

public class Notes {

}

// @PathVariable
// @RequestParam
// @MatrixVariable

// URI template pattern

// / ..../product/laptop
// ..../product/tablet
// ..../product/mobile

// burada onlarca link olabilir , her birine karsilik bir @RequestMapping
// tanimlayamayiz.
// bu noktada bize yardimci olarak @PathVariable annotation ini kullaniriz.

// Request Parameters

// dusunelim ki , e-ticaret sitesinde yuzlerce urun bulunmaktadir. her birine
// tikladigimizda urun detay sayfasi acilir.
// burada ne her urun icin farkli bir jsp sayfasi kullanilir ne de her birinin
// @RequestMapping i farklidir.

// iste bu noktada @RequestParam annotationini kullaniliriz.

// Matrix Variable

// dusunelim ki -> marka/brand ve category gore filtreleme yapabiliriz.burada birden fazla category ve veya marka secebiliriz.
// bu durumda filtreleme kullanmak gereklidir.
// bunun icin Spring MVC bize @MatrixVariable annotationini sunmaktadir.