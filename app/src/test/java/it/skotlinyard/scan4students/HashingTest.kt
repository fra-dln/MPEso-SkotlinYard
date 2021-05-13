package it.skotlinyard.scan4students
import it.skotlinyard.scan4students.utils.Hashing
import org.junit.Test

class HashingTest {
    @Test
    fun testMd5() {
        val hash = Hashing()
        System.out.println(hash.md5("ciao"))
    }


}