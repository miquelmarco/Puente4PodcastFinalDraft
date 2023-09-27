setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                episodes: [],
                filteredEp: [],
                seasons: [],
                checked: [],
                searchInput: '',
                isLoading: false
            }
        },
        created() {
            axios.get(`/api/episodes`)
            .then(res => {
                this.episodes = res.data
                this.seasons = Array.from(new Set(this.episodes.map(episode => episode.seasonNumber)))
            }).catch(err => console.log(err))
        },
    methods: {
        filtroEpCheckSearc2() {
            this.filteredEp = this.episodes.filter(episode => episode.name.toLowerCase().includes(this.searchInput.toLowerCase())
            && (this.checked.includes(episode.seasonNumber) || this.checked.length == 0)).sort((a, b) => b.id - a.id)
        }
    },
    computed: {
        filtroEpCheckSearch() {
            this.filteredEp = this.episodes.filter(episode => episode.name.toLowerCase().includes(this.searchInput.toLowerCase())
            && (this.checked.includes(episode.seasonNumber) || this.checked.length == 0)).sort((a, b) => b.id - a.id)
        }
    }
}).mount("#app")
},1000)