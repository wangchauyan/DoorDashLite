package idv.chauyan.doordashlite.presentation

interface BaseView<in P : BasePresenter> {
  fun setPresenter(presenter: P)
}