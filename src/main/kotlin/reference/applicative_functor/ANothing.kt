package reference.applicative_functor

object ANothing : AMaybe<kotlin.Nothing>() {
    override fun toString(): String = "ANothing"

    override fun <B> apply(f: Applicative<(kotlin.Nothing) -> B>): AMaybe<B> = ANothing

    override fun <B> fmap(f: (kotlin.Nothing) -> B): AMaybe<B> = ANothing
}