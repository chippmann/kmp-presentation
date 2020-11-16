package util

import kpresentation.SlideContentProps
import kpresentation.SlideProps
import react.RElementBuilder

typealias SlideHandler = RElementBuilder<SlideProps>.(SlideContentProps) -> Unit